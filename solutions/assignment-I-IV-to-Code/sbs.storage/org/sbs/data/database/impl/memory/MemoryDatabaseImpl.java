/******************************************************************************
*    Copyright (c)  2019-2021, Jeferson Souza (thejefecomp) - 
*    jefecomp.official@gmail.com. All rights reserved. 
*
*    Redistribution and use in source and binary forms, with or without 
*    modification, are permitted provided that the following conditions are 
*    met: 
*
*    1. Redistributions of source code must retain the above copyright notice,
*       this list of conditions and the following disclaimer. 
*
*    2. Redistributions in binary form must reproduce the above copyright
*       notice, this list of conditions and the following disclaimer in the 
*       documentation and/or other materials provided with the distribution. 
*
*    3. All advertising materials mentioning features or use of this software
*       must display the following acknowledgement: This product includes
*       software developed by Jeferson Souza (thejefecomp). 
*
*    4. Neither the name of Jeferson Souza (thejefecomp) nor the names of its
*       contributors may be used to endorse or promote products derived from 
*       this software without specific prior written permission.
*
*    THIS SOFTWARE IS PROVIDED BY JEFERSON SOUZA (THEJEFECOMP) "AS IS" AND ANY
*    EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
*    WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
*    DISCLAIMED. IN NO EVENT SHALL JEFERSON SOUZA (THEJEFECOMP) BE LIABLE FOR
*    ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
*    DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
*    SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
*    CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
*    LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
*    OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
*    SUCH DAMAGE.
******************************************************************************/

package org.sbs.data.database.impl.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.stream.Collectors;

import org.sbs.data.database.Database;

public class MemoryDatabaseImpl implements Database{

    private static MemoryDatabaseImpl instance;
    
    private Map<String, Map<?,?>> databaseEntityStorage;

    private MemoryDatabaseImpl(){
    	
    	this.databaseEntityStorage = new TreeMap<String, Map<?,?>>();
    }
    
    private <T> Set<String> findClassCastSet(Class<T> entityClass){
    	
    	return this.databaseEntityStorage.keySet().stream()
    	                                          .filter(key -> {
    	    boolean result = true;
    	                                   
    	    try{                               
    	    
    	          Class<?> clazz = Class.forName(key);
    			
    		      result = clazz.asSubclass(entityClass) == clazz;
				
			} catch (ClassCastException | ClassNotFoundException e){
				
				result = false;
			}
			finally{
			
			    return result;
			
			}}).collect(Collectors.toUnmodifiableSet());
    }
    
    private <K,T> boolean containsKeyInternal(K key, Class<T> entityClass) {
    	
    	return this.databaseEntityStorage
    	           .containsKey(entityClass.getName()) 
    	           ? this.databaseEntityStorage
    	                 .get(entityClass.getName())
    	                 .containsKey(key) 
    	           : false;   
    }
    
    @SuppressWarnings("unchecked")
	private <K,T> T insertOrUpdateInternal(K key, T entity) {
    	
    	if(!this.containsKeyInternal(key, entity.getClass())){
    		
    		this.addEntityStorage(entity.getClass());
    	}
    	
    	((Map<K,T>)this.databaseEntityStorage
    	               .get(entity.getClass().getName()))
    	               .put(key, entity);
    	
    	return entity;
    }
    
    public static Database getInstance(){

	synchronized(MemoryDatabaseImpl.class){

	    if(instance == null){

		instance = new MemoryDatabaseImpl();
	    }
	}

	return instance;
    }
    
    public static Database getNewInstance() {
    	
    	return new MemoryDatabaseImpl(); 
    }
    
    public <K,T> boolean addEntityStorage(Class<T> entityClass) {
    	
    	if(this.databaseEntityStorage.containsKey(entityClass.getName())) {
    		
    		return false;
    	}
    	
    	this.databaseEntityStorage.put(entityClass.getName(), new TreeMap<K,T>());
    	
    	
    	return true;
    	
    }
    
    @SuppressWarnings(value = "unchecked")
    @Override
    public <K,T> T delete(K key, Class<T> entityClass){

	    if(!this.containsKeyInternal(key, entityClass)) {
	    	
	    	return null;
	    }
	    
	    return (T) this.databaseEntityStorage.get(entityClass.getName()).remove(key);
	    
    }

    @SuppressWarnings("unchecked")
    @Override
	public <K,T> T find(K key, Class<T> entityClass){
	
	    if(!this.containsKeyInternal(key,entityClass)) {
		
    		Set<String> classCastSet = this.findClassCastSet(entityClass);
    		
    		if (classCastSet.isEmpty()){
    		
    		    return null;
    		}
    		
    		return (T) this.databaseEntityStorage.entrySet().stream()
    		                                     .filter(entry ->
    		                                        classCastSet.contains(entry.getKey()) &&
    		                                        this.databaseEntityStorage.get(entry.getKey())
    		                                                                  .containsKey(key))
    		                     .map(entry -> this.databaseEntityStorage
    		                                       .get(entry.getKey())
    		                                       .get(key))
    		                     .findFirst().orElse(null);
    	}
    	
    	return ((Map<K,T>)this.databaseEntityStorage.get(entityClass.getName())).get(key);
    }
    
    @SuppressWarnings({ "unchecked"})
	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
    	
    	if(!this.databaseEntityStorage.containsKey(entityClass.getName())) {
    		
    		Set<String> classCastSet = this.findClassCastSet(entityClass);
    		
    		List<T> resultList = new ArrayList<>();
    		
    		classCastSet.stream().forEach(className -> {
    		
    		     resultList.addAll((Collection<T>)this.databaseEntityStorage.get(className).values());
    		     
    		     return;
    		});
    	
            return resultList;
        }
                
        return (List<T>)this.databaseEntityStorage.get(entityClass.getName()).values()
                                                                             .stream()
                                             .collect(Collectors.toUnmodifiableList());
	}

	@Override
    public <K,T> T insert(K key, T entity){

    	return this.insertOrUpdateInternal(key, entity);
    }

    
    @Override
    public <K,T> T update(K key, T entity){

    	return this.insertOrUpdateInternal(key, entity);
    }
}

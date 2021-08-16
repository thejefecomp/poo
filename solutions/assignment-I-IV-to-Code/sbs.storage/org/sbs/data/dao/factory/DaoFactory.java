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

package org.sbs.data.dao.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

import org.sbs.data.database.Database;
import org.sbs.data.database.impl.memory.MemoryDatabaseImpl;
import org.sbs.data.dao.Dao;

public class DaoFactory {
		
	private static DaoFactory instance;
	
	private Map<String, Dao<?>> daoMap;
	
	private DaoFactory() {
		
		this.daoMap = new TreeMap<>();
	}
	
	public static DaoFactory getInstance() {
		
		synchronized(DaoFactory.class) {
			
			if(instance == null) {
				
				instance = new DaoFactory();
			}
		}
		
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getDao (Class<?> entityClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		
		if(this.daoMap.containsKey(entityClass.getName())){
			
			return (T) daoMap.get(entityClass.getName());
		}
		
		DaoEnum daoEntry = DaoEnum.valueOf(entityClass.getSimpleName().toUpperCase());
		
		T daoImpl = daoEntry == null ? null : (T) daoEntry.getDaoClass().getDeclaredConstructor(Database.class).newInstance(MemoryDatabaseImpl.getInstance());
		
		this.daoMap.put(entityClass.getName(), (Dao<?>)daoImpl);
		
		return daoImpl;
	}
}

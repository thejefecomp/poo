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

package org.sbs.data.facade.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.sbs.data.dao.Dao;
import org.sbs.data.dao.factory.DaoEnum;
import org.sbs.data.dao.factory.DaoFactory;
import org.sbs.data.facade.DataFacade;

public class DataFacadeImpl implements DataFacade {
	
	private DaoFactory daoFactory = DaoFactory.getInstance();
	
	private <T> Dao<T> getDao(Class<T> entityClass){
		
		try {
			return this.daoFactory.getDao(DaoEnum.valueOf(entityClass.getSimpleName().toUpperCase()).getEntityClass());
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public <K, T> T delete(K key, Class<T> entityClass) {
		
		Dao<T> daoImpl = this.getDao(entityClass);
		
		return daoImpl == null ? null : daoImpl.delete(key);
	}

	@Override
	public <T> List<T> delete(Map<String, Object> attributeMap, Class<T> entityClass) {
		
		Dao<T> daoImpl = this.getDao(entityClass);
		
		return daoImpl == null ? null : daoImpl.delete(attributeMap);
	}

	@Override
	public <K, T> T find(K key, Class<T> entityClass) {
		
		Dao<T> daoImpl = this.getDao(entityClass);
		
		return daoImpl == null ? null : daoImpl.find(key);
	}

	@Override
	public <T> List<T> find(Map<String, Object> attributeMap, Class<T> entityClass) {
		
		Dao<T> daoImpl = this.getDao(entityClass);
		
		return daoImpl == null ? null : daoImpl.find(attributeMap);
	}
	
	@Override
	public <T> List<T> findAll(Class<T> entityClass){
	
	    Dao<T> daoImpl = this.getDao(entityClass);
		
		return daoImpl == null ? null : daoImpl.findAll();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, T> T insert(K key, T entity) {
		
		Dao<T> daoImpl = (Dao<T>) this.getDao(entity.getClass());
		
		return daoImpl == null ? null : daoImpl.insert(key, entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, T> T update(K key, T entity) {
		
		Dao<T> daoImpl = (Dao<T>) this.getDao(entity.getClass());
		
		return daoImpl == null ? null : daoImpl.update(key, entity);
	}
}

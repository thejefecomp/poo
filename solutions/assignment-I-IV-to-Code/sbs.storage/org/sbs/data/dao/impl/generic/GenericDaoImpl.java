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
/*
 * This is a generic implementation of the Data Access Object (DAO) design pattern, 
 * which is utilised as the foundation to define specialised wrapper classes. This
 * generic implementation can be parameterised and used in its own, or if you 
 * need to use a wrapper for each one of the entities in the data model of this 
 * Design Pattern example's implementation, you must use the wrapper classes 
 * present in the package org.ppr.patterns.dao.impl.
 * 
 */

package org.sbs.data.dao.impl.generic;

import java.util.List;
import java.util.Map;

import org.sbs.data.database.Database;
import org.sbs.data.dao.Dao;

public class GenericDaoImpl<T> implements Dao<T> {

	private Class<T> entityClass;
	
	private Database database;
	
	public GenericDaoImpl(Class<T> entityClass, Database database) {
	
		this.entityClass = entityClass;
		
		this.database = database;
	}
	
	@Override
	public <K> T delete(K key) {
		
		return this.database.delete(key, this.entityClass);
	}

	@Override
	public List<T> delete(Map<String, Object> attributeMap) {
		
		return null;
	}

	@Override
	public <K> T find(K key) {
		
		return this.database.find(key, this.entityClass);
	}

	@Override
	public List<T> findAll() {
	
		return this.database.findAll(this.entityClass);
	}

	@Override
	public List<T> find(Map<String, Object> attributeMap) {

		return null;
	}

	@Override
	public <K> T insert(K key, T entity) {

		return this.database.insert(key, entity);
	}

	@Override
	public <K> T update(K key, T entity) {
		
		return this.database.update(key, entity);
	}
}

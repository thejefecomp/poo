package org.sbs.data.dao.impl;

/******************************************************************************
*    Copyright (c)  2021, Jeferson Souza (thejefecomp) - 
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.sbs.data.dao.impl.generic.GenericDaoImpl;

import org.sbs.data.database.Database;
import org.sbs.entidade.PessoaFisica;

public class PessoaFisicaDao extends GenericDaoImpl<PessoaFisica>{
	
	private PessoaFisica findCpf(Long cpf){
	
	    return this.findAll()
	               .stream()
	               .filter(cliente -> cliente.getCpf().equals(cpf))
	               .findFirst().orElse(null);
	}
	
	public PessoaFisicaDao(Database database){

		super(PessoaFisica.class, database);
	}
	
	@Override
	public List<PessoaFisica> find(Map<String, Object> attributeMap) {

        if (attributeMap.keySet().contains("CPF")){
        
            PessoaFisica cliente = findCpf((Long)attributeMap.get("CPF"));
            
            return cliente != null ? Arrays.asList(cliente) : null;
        }

		return null;
	}
}


package org.sbs.controller.impl;

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

import java.util.Map;
import java.util.HashMap;

import org.sbs.controller.IController;
import org.sbs.controller.IDataController;
import org.sbs.controller.ControllerOperationEnum;

import org.sbs.data.business.impl.SBSBusinessImpl;
import org.sbs.data.facade.impl.DataFacadeImpl;


import org.sbs.entidade.PessoaFisica;
import org.sbs.entidade.Sapato;

import org.sbs.view.vo.PessoaFisicaVO;
import org.sbs.view.vo.SapatoVO;
 
 
 public class ControllerImpl implements IController{
	 
	 private Map<Class<?>, IDataController> dataControllerMap = new HashMap<>();
	 
	 
	 
	 public ControllerImpl(){
		 
		 SBSBusinessImpl sbsNegocio = new SBSBusinessImpl(new DataFacadeImpl());
		 
		 this.dataControllerMap.put(PessoaFisica.class,new ClienteController(sbsNegocio));
		 
		 SapatoController sapatoController = new SapatoController(sbsNegocio);
		 
		 //Popular Sapatos staticamente na Base de dados para uso de outras funcionalidades.
		 sapatoController.popularSapatos();
		 
		 this.dataControllerMap.put(Sapato.class,sapatoController);
		 
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Override
	 public Object execute(ControllerOperationEnum operation, Object ... data){
		 
		 switch(operation){
			 
			 case ADD_PESSOA_FISICA:

				  return ((ClienteController)this.dataControllerMap.get(PessoaFisica.class))
				                                 .addPessoaFisica((PessoaFisicaVO)data[0]);

            case FIND_ALL_PESSOA_FISICA:
				 
				 return ((ClienteController)this.dataControllerMap.get(PessoaFisica.class))
				                                .findAllPessoaFisica();
				                                
	        case FIND_ALL_SAPATO:
				 
				 return ((SapatoController)this.dataControllerMap.get(Sapato.class))
				                                .findAllSapato();

			 case FIND_PESSOA_FISICA:
				 
				 return ((ClienteController)this.dataControllerMap.get(PessoaFisica.class))
				                                .findPessoaFisica((Long)data[0]);
				                                     
	        case FIND_PESSOA_FISICA_CPF:
				 
				 return ((ClienteController)this.dataControllerMap.get(PessoaFisica.class))
				                                .findPessoaFisicaCpf((Long)data[0]);


			 case REMOVE_PESSOA_FISICA:
				 
				 return ((ClienteController)this.dataControllerMap.get(PessoaFisica.class))
				                                .removePessoaFisica((Long)data[0]);
			 default:
		 }
		 
		 return null;
	 }	 
 }

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

import java.util.List;

import java.util.function.Function;

import java.util.stream.Collectors;

import org.sbs.controller.IDataController;

import org.sbs.data.business.ISBSBusiness;
import org.sbs.data.business.ClienteSBSBusinessOpEnum;

import org.sbs.entidade.PessoaFisica;

import org.sbs.view.vo.PessoaFisicaVO;

public class ClienteController implements IDataController{

    private ISBSBusiness sbsNegocio;

	private Function<PessoaFisica,PessoaFisicaVO> fEntidadeToVO = entidade 
												  -> new PessoaFisicaVO(
													 entidade.getCpf(),
													 entidade.getEmail(),
													 entidade.getNome(),
													 entidade.getRg(),
													 entidade.getSobrenome());
													 
    private Function<PessoaFisicaVO,PessoaFisica> fVOToEntidade = vo
												  -> {
												  
	    PessoaFisica cliente =  new PessoaFisica(vo.getCpf(),vo.getNome(),
								 vo.getRg(),vo.getSobrenome());

		 cliente.setEmail(vo.getEmail());

		return cliente;									  
	};
	
	@SuppressWarnings("unchecked")
	private <T,R> List<R> executaOperacaoLista(T parametro, ClienteSBSBusinessOpEnum operacao){
	
	
	    switch(operacao){
	
	           case FIND_ALL_PESSOA_FISICA: return (List<R>) this.sbsNegocio
                                                                 .findAllPessoaFisica()
                                                                 .stream()
                                                                 .map(pessoa -> this.map(pessoa))
                                                                 .collect(Collectors.toUnmodifiableList());
                                                    
               default:
       }
                                                    
       return null;                                                                              
	}
	
	@SuppressWarnings("unchecked")
	private <T,R> R executaOperacao(T parametro, ClienteSBSBusinessOpEnum operacao){
	
	    if (parametro == null){
	    
	        return null;
	    }
	
	    switch(operacao){
	    
	         case ADD_PESSOA_FISICA: 
	         
	                         PessoaFisica cliente = this.map((PessoaFisicaVO)parametro);
		 
		                     return (R) this.sbsNegocio.addPessoaFisica(cliente);
                                                         
             case FIND_PESSOA_FISICA: return (R) this.map(this.sbsNegocio
                                                       .findPessoaFisica((Long)parametro));
                                                       
                             
             case FIND_PESSOA_FISICA_CPF: return (R) this.map(this.sbsNegocio
                                                       .findPessoaFisicaCpf((Long)parametro));
    
    
             case REMOVE_PESSOA_FISICA: return (R) this.sbsNegocio.removePessoaFisica((Long)parametro);
             
             default:
	    }
	
	    return null;
	}
	
	public ClienteController(ISBSBusiness sbsNegocio){
	
	    this.sbsNegocio = sbsNegocio;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T,R> R map(T tipo){
	
	    if (tipo == null){
	    
	        return null;
	    }
        else if (tipo.getClass().equals(PessoaFisica.class)){
        
            return (R) this.map(this.fEntidadeToVO, (PessoaFisica) tipo);
        }
        else if(tipo.getClass().equals(PessoaFisicaVO.class)){
        
            return (R) this.map(this.fVOToEntidade, (PessoaFisicaVO) tipo);
        }

	    return null;
	}
	
	public Boolean addPessoaFisica(PessoaFisicaVO vo) {
		 
		return this.executaOperacao(vo, ClienteSBSBusinessOpEnum.ADD_PESSOA_FISICA);
	 }
	 
	 public List<PessoaFisicaVO> findAllPessoaFisica(){
	 
	    return this.executaOperacaoLista(null, ClienteSBSBusinessOpEnum.FIND_ALL_PESSOA_FISICA); 
	 }
	 
	 public PessoaFisicaVO findPessoaFisica(Long rg) {
		 
		return this.executaOperacao(rg, ClienteSBSBusinessOpEnum.FIND_PESSOA_FISICA); 
	 }
	 
     public PessoaFisicaVO findPessoaFisicaCpf(Long cpf) {
		 
		 return this.executaOperacao(cpf, ClienteSBSBusinessOpEnum.FIND_PESSOA_FISICA_CPF); 
	 }
	 
	 public Integer removePessoaFisica(Long rg) {
		 
		 return this.executaOperacao(rg, ClienteSBSBusinessOpEnum.REMOVE_PESSOA_FISICA);
    }
}

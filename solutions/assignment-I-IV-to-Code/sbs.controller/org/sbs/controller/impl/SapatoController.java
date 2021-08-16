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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.sbs.controller.IDataController;

import org.sbs.data.business.ISBSBusiness;

import org.sbs.entidade.Sapato;
import org.sbs.entidade.common.enums.OrigemTamanho;

import org.sbs.view.vo.SapatoVO;
import org.sbs.view.vo.enums.OrigemTamanhoEnum;

public class SapatoController implements IDataController{

    private ISBSBusiness sbsNegocio;

	private Function<Sapato,SapatoVO> fEntidadeToVO = entidade 
												  -> {
												  
		  Map<OrigemTamanhoEnum, Integer> mTamanhoMap = null;	
		  
		  if(entidade.getMTamanho() != null){
		  
		    mTamanhoMap = entidade.getMTamanho().entrySet()
                            .stream()
                            .collect(Collectors.toMap(entry -> OrigemTamanhoEnum.valueOf(entry.getKey().toString()),
                                                      entry -> entry.getValue()));
		  }  									  
		   
		  return new SapatoVO(entidade.getDescricao(),
						      entidade.getMarca(),
						      entidade.getModelo(),
						      entidade.getNumeroSerie(),
						      mTamanhoMap);
    };
													 
    private Function<SapatoVO,Sapato> fVOToEntidade = vo
												  -> {
												  
        Map<OrigemTamanho, Integer> mTamanhoMap = null;
        
        if(vo.getMTamanho() != null){
        
            mTamanhoMap = vo.getMTamanho().entrySet()
                            .stream()
                            .collect(Collectors.toMap(entry -> OrigemTamanho.valueOf(entry.getKey().toString()),
                                                      entry -> entry.getValue()));
        }
        
        return new Sapato(vo.getDescricao(),
                          vo.getMarca(),
                          vo.getModelo(),
                          vo.getNumeroSerie(),
                          mTamanhoMap);
	};
	
	@SuppressWarnings("unchecked")
	private <R> List<R> findAndConvertListSapato(){
	
	    return (List<R>)this.sbsNegocio.findAllSapato()
                                       .stream()
                                       .map(sapato -> this.map(sapato))
                                       .collect(Collectors.toUnmodifiableList());
	}
	
	public SapatoController(ISBSBusiness sbsNegocio){
	
	    this.sbsNegocio = sbsNegocio;
	}	
	 
	public void popularSapatos(){
	
	    Map<OrigemTamanho,Integer> mTamanho = new HashMap<>();
	    
	    mTamanho.put(OrigemTamanho.BR,40);
	    
	    Sapato sapato = new Sapato("Sapato XPTO",
	                               "XPTO",
	                               "XPTO Delta",
	                               12345L,
	                               mTamanho);
	                               
	  this.sbsNegocio.addSapato(sapato);
	                               
	   mTamanho = new HashMap<>();
	    
	   mTamanho.put(OrigemTamanho.BR,42);
	    
	   sapato = new Sapato("Sapato DRE",
	                       "DRE",
	                       "DRE Gama",
	                       1234L,
	                       mTamanho);
	                               
	  this.sbsNegocio.addSapato(sapato);
	} 
	 
    public Boolean addSapato(SapatoVO vo){
    
        return this.sbsNegocio.addSapato(this.map(vo));
    }
    
    public <R extends SapatoVO> List<SapatoVO> findAllSapato(){
    
        return this.findAndConvertListSapato();
    }
		
	@Override
	@SuppressWarnings("unchecked")
	public <T,R> R map(T tipo){
	
	    if (tipo == null){
	    
	        return null;
	    }
        else if (tipo.getClass().equals(Sapato.class)){
        
            return (R) this.map(this.fEntidadeToVO, (Sapato) tipo);
        }
        else if(tipo.getClass().equals(SapatoVO.class)){
        
            return (R) this.map(this.fVOToEntidade, (SapatoVO) tipo);
        }

	    return null;
	}
	
	
}

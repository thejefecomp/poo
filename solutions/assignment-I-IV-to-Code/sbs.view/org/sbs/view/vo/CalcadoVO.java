package org.sbs.view.vo;

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

import org.sbs.view.vo.enums.OrigemTamanhoEnum;

public class CalcadoVO{
    
    private String descricao;
    
    private String marca;
    
    private String modelo;

    private Map<OrigemTamanhoEnum,Integer> mTamanho; 
    
    private Long numeroSerie;

    /*
        Construtor com parâmetros.
    */
    public CalcadoVO(String descricao,String marca,String modelo,Long numeroSerie,
				     Map<OrigemTamanhoEnum,Integer> mTamanho){
        
        this.descricao = descricao;
        
        this.marca = marca;
        
        this.modelo = modelo;
        
        this.numeroSerie = numeroSerie;

        this.mTamanho = mTamanho;
        
        this.numeroSerie = numeroSerie;
    }

    /*
        Métodos getters e setters.
    */
    
    public String getDescricao(){
    
        return this.descricao;
    }

    public Long getId(){
    
        return this.getNumeroSerie();
    }

    public String getMarca(){

        return this.marca;
    }

    public String getModelo(){

        return this.modelo;
    }

	public Long getNumeroSerie(){

		return this.numeroSerie;
	}
    
    public Map<OrigemTamanhoEnum,Integer> getMTamanho(){

        return this.mTamanho;
    }
    
    public void setDescricao(String descricao){
        
        this.descricao = descricao;
    }
    
    public void setId(Long id){
    
        this.setNumeroSerie(id);
    }

    public void setMarca(String marca){

        this.marca = marca;
    }

    public void setModelo(String modelo){

        this.modelo = modelo;
    }

	public void setNumeroSerie(Long numeroSerie){

		this.numeroSerie = numeroSerie;
	}

    public void setMTamanho(Map<OrigemTamanhoEnum,Integer> mTamanho){

        this.mTamanho = mTamanho;
    }

    public void adicionaOuModificaTamanho(OrigemTamanhoEnum origem,Integer tamanho){

		this.mTamanho.put(origem,tamanho);
    }

    public Integer removeTamanho(OrigemTamanhoEnum origem){

		return this.mTamanho.remove(origem);
    }	
}


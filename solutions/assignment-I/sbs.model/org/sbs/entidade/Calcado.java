package org.sbs.entidade;

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

import org.sbs.entidade.common.Entidade;
import org.sbs.entidade.common.enums.OrigemTamanho;

public class Calcado extends Entidade{

    /*
        Pode-se criar um enumerado para as marcas e os modelos. Entretanto, o 
        programa fica mais restritivo, e com a necessidade de alterar o 
        código-fonte aquando do cadastro de calçado de marcas e modelos não 
        identificados anteriormente. No caso das bandeiras e das modalidades
        de pagamento, a mudança do código-fonte não transforma-se em uma
        restrição forte, a considerar a necessidade do suporte e comunicação
        com os sistemas externos de pagamento, e clubes de fidelidade.
    */
    
    private String modelo;

    private Map<OrigemTamanho,Integer> mTamanho; 

    /*
        Construtor com parâmetros.
    */
    public Calcado(String descricao,String marca,String modelo,Long numeroSerie,
				   Map<OrigemTamanho,Integer> mTamanho){

		super(descricao,numeroSerie,marca);
        
        this.modelo = modelo;

        this.mTamanho = mTamanho;
    }

    /*
        Métodos getters e setters.
    */

    public String getMarca(){

        return this.getNome();
    }

    public String getModelo(){

        return this.modelo;
    }

	public Long getNumeroSerie(){

		return this.getId();
	}
    
    public Map<OrigemTamanho,Integer> getMTamanho(){

        /*
           Retorna-se diretamente o mapa (por agora). 
		   Pensem nos limites de tipos ;-).
        */
        return this.mTamanho;
    }

    public void setMarca(String marca){

        this.setNome(marca);
    }

    public void setModelo(String modelo){

        this.modelo = modelo;
    }

	public void setNumeroSerie(Long numeroSerie){

		this.setId(numeroSerie);
	}

    public void setMTamanho(Map<OrigemTamanho,Integer> mTamanho){

        this.mTamanho = mTamanho;
    }

    /*
        Método para adicionar um tamanho novo a um calçado já existente.
    */
    public void adicionaOuModificaTamanho(OrigemTamanho origem,Integer tamanho){

		this.mTamanho.put(origem,tamanho);
    }

	 /*
        Método para remover um tamanho de um calçado já existente.
    */
    public Integer removeTamanho(OrigemTamanho origem){

		return this.mTamanho.remove(origem);
    }	
}


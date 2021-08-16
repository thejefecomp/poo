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

import java.time.LocalDate;
import java.util.List;

import org.sbs.entidade.common.Entidade;
import org.sbs.entidade.common.enums.Bandeira;
import org.sbs.entidade.common.enums.ModalidadePagamento;


public class Cartao extends Entidade{

    /*
        Pode-se utilizar enumerados a substituir os mapeamentos realizados 
		com inteiros. O código fica mais intuitivo. Disponibilizado nos 
		comentários alternativa sem o uso de enumerados.
        
    */

    private LocalDate dataValidade;

    private Boolean fidelidade;

    /*
        Mapeamento utilizado (sem o uso de enumerados):

        1 - Mastercard;  
        
        2 - Visa.

        private List<Integer> lBandeiras;

        DETALHE: Pode-se pensar na extensibilidade de usar as bandeiras para 
        fidelidade ;-).
    */
    private List<Bandeira> lBandeiras;

    /*
        Mapeamento utilizado (sem o uso de enumerados):

        1 - Crédito;  
        
        2 - Débito.
    
        private List<Integer> lModalidadesPagamento;
    */
    private List<ModalidadePagamento> lModalidadesPagamento;

    private Integer pontos;

    /*
        Construtores com parâmetros.
    */

    public Cartao(LocalDate dataValidade, List<Bandeira> lBandeiras,
                  List<ModalidadePagamento> lModalidadesPagamento,String nomeCartao,
                  Long numeroCartao){
            
            this(dataValidade,null,lBandeiras,lModalidadesPagamento,
                 nomeCartao,numeroCartao,null,null);
    }
    
    public Cartao(LocalDate dataValidade, String descricao, 
                  List<Bandeira> lBandeiras, 
                  List<ModalidadePagamento> lModalidadesPagamento,String nomeCartao,
                  Long numeroCartao,Integer pontos,Boolean fidelidade){

        super(descricao,numeroCartao,nomeCartao);

        this.dataValidade = dataValidade;

        this.fidelidade = fidelidade;

        this.lBandeiras = lBandeiras;

        this.lModalidadesPagamento = lModalidadesPagamento;

        this.pontos = pontos;   
    }

    /*
        Métodos getters e setters.
    */

    public LocalDate getDataValidade(){

        return this.dataValidade;
    }

    public List<Bandeira> getLBandeiras(){

        /*
           Retorna-se diretamente a lista (por agora).
		   Pensem nos limites de tipos ;-).
        */
        return this.lBandeiras;
    }

    public List<ModalidadePagamento> getLModalidadesPagamento(){

        /*
           Retorna-se diretamente a lista (por agora).
		   Pensem nos limites de tipos ;-).
        */
        return this.lModalidadesPagamento;
    }

    public String getNomeCartao(){

        return this.getNome();
    }

    public Long getNumeroCartao(){

        return this.getId();
    }

    public Integer getPontos(){

        return this.pontos;
    }

	/*
		Convenção utilizada para tipos booleanos, em substituição ao padrão 
		getNomeDoAtributo().
	*/
    public Boolean temFidelidade(){

        return this.fidelidade;
    }

    public void setDataValidade(LocalDate dataValidade){

        this.dataValidade = dataValidade;
    }

    public void setFidelidade(Boolean fidelidade){

        this.fidelidade = fidelidade;
    }

    public void setLBandeiras(List<Bandeira> lBandeiras){

        this.lBandeiras = lBandeiras;
    }

    public void setLModalidadesPagamento(List<ModalidadePagamento> 
										 lModalidadesPagamento){

        this.lModalidadesPagamento = lModalidadesPagamento;
    }

    public void setNomeCartao(String nomeCartao){

        this.setNome(nomeCartao);
    }

    public void setNumeroCartao(Long numeroCartao){

        this.setId(numeroCartao);
    }
    
    public void setPontos(Integer pontos){

        this.pontos = pontos;
    }
}


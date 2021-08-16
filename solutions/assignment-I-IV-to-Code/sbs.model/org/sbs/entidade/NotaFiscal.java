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

import java.time.LocalDateTime;

import java.util.List;

import org.sbs.entidade.common.Entidade;

public class NotaFiscal extends Entidade{

	/*
		 Não se vai representar as alíquotas de impostos, deduzidas dos preços 
		 unitários de venda de cada produto, para não complicar muito o modelo 
		 neste exato momento. A extensão com tais alíquotas não é algo difícil 
		 de ser realizado, basta trabalhar um bocadinho na organização do 
		 armazenamento dos preços :-D.
	*/

	private LocalDateTime dataEmissao;

	private List<Venda> lVendas;

	private Float valorTotal;

	/*
        Construtor com parâmetros.
    */
	
	public NotaFiscal(List<Venda> lVendas,Long numeroSerie,Float valorTotal){

		super(null,numeroSerie,null);

		this.dataEmissao = LocalDateTime.now();

		this.lVendas = lVendas;

		this.valorTotal = valorTotal;
	}

	/*
        Métodos getters e setters.
    */

	public LocalDateTime getDataEmissao(){

		return this.dataEmissao;
	}

	public List<Venda> getLVendas(){

		/*
           Retorna-se diretamente a lista (por agora).
		   Pensem nos limites de tipos ;-).
        */
		return this.lVendas;
	}
	public Long getNumeroSerie(){

		return this.getId();
	}

	public Float getValorTotal(){

		return this.valorTotal;
	}
}


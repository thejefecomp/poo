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

import org.sbs.entidade.common.Entidade;
import org.sbs.entidade.common.enums.ModoPagamento;
import org.sbs.entidade.common.enums.StatusPagamento;
import org.sbs.entidade.common.enums.TipoPagamento;

public class Pagamento extends Entidade{

	/*
		O uso de enumerados deixa o código-fonte mais intuitivo, mas como
		eu ainda não vos ensinei, os mesmos poderiam ter sido substituídos por 
		inteiros com mapeamento associado, tal como explicado abaixo.
	*/

	private Cartao cartaoPagamento;

	/*
		 A desconsiderar o uso de enumerados, poderia-se substituir o atributo 
		 por um inteiro, onde:

		 1 -> Pagamento realizado à prazo;

		 2 -> Pagamento realizado à vita.

		 private Integer modoPagamento;
	*/

	private ModoPagamento modoPagamento;

	private Integer parcelasPagas;

	private Integer quantidadeParcelas;

	/*
		 A desconsiderar o uso de enumerados, poderia-se substituir o atributo 
		 por um inteiro, onde:

		 1 -> Pagamento em aberto;

		 2 -> Pagamento quitado.

		 private Integer statusPagamento;
	*/

	private StatusPagamento statusPagamento;

	/*
		 A desconsiderar o uso de enumerados, poderia-se substituir o atributo 
		 por um inteiro, onde:

		 1 -> Pagamento com boleto;

		 2 -> Pagamento com cartão;

		 3 -> Pagamento em dinheiro.

		 private Integer tipoPagamento;
	*/
	
	private TipoPagamento tipoPagamento;

	/*
        Construtor default sem parâmetros.
    */
	public Pagamento(){

		this(null,null,null,null,null,null,null);
	}

	/*
        Construtor com parâmetros.
    */
	public Pagamento(Cartao cartaoPagamento,Long id,ModoPagamento modoPagamento,
					 Integer parcelasPagas,Integer quantidadeParcelas,
					 StatusPagamento statusPagamento,
					 TipoPagamento tipoPagamento){
		
		super(null,id,null);

		this.cartaoPagamento = cartaoPagamento;

		this.modoPagamento = modoPagamento;

		this.parcelasPagas = parcelasPagas;

		this.quantidadeParcelas = quantidadeParcelas;

		this.statusPagamento = statusPagamento;

		this.tipoPagamento = tipoPagamento;
	}

	/*
        Métodos getters e setters.
    */
	public Cartao getCartaoPagamento(){

		return this.cartaoPagamento;
	}

	public ModoPagamento getModoPagamento(){

		return this.modoPagamento;
	}

	public Integer getParcelasPagas(){

		return this.parcelasPagas;
	}

	public Integer getQuantidadeParcelas(){

		return this.quantidadeParcelas;
	}

	public StatusPagamento getStatusPagamento(){

		return this.statusPagamento;		
	}

	public TipoPagamento getTipoPagamento(){

		return this.tipoPagamento;	
	}
}


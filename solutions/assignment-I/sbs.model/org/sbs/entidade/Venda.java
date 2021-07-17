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

public class Venda extends Entidade{

	private Float descontoVenda;

	private Map<Long,ItemVenda> mItensVenda;

	private Pagamento pagamento;

	private Float valorTotal;

	public class ItemVenda{

		private Calcado calcado;

		private Integer descontoItem;		

		private Integer quantidade;

		private Float valorUnitario;
	
		/*
        	Construtores com parâmetros.
    	*/

		public ItemVenda(Calcado calcado,Integer quantidade,
			   Float valorUnitario){

			this(calcado,null,quantidade,valorUnitario);

		}

		public ItemVenda(Calcado calcado,Integer descontoItem,
						 Integer quantidade,Float valorUnitario){

				this.calcado = calcado;

				this.descontoItem = descontoItem;

				this.quantidade = quantidade;

				this.valorUnitario = valorUnitario;
		}


		/*
        	Métodos getters e setters.
    	*/

		public Calcado getCalcado(){

			return this.calcado;
		}

		public Integer getDescontoItem(){

			return this.descontoItem;
		}

		public Integer getQuantidade(){

			return this.quantidade;
		}
		
		public Float getValorunitario(){

			return this.valorUnitario;
		}

		public void setCalcado(Calcado calcado){

			this.calcado = calcado;
		}

		public void setDescontoItem(Integer descontoItem){

			this.descontoItem = descontoItem;
		}

		public void setQuantidade(Integer quantidade){

			this.quantidade = quantidade;
		}

		public void setValorUnitario(Float valorUnitario){

			this.valorUnitario = valorUnitario;
		}
	}

	/*
        Construtor default sem parâmetros.
    */
	public Venda(){

		this(null,null,null,null,null);	
	}

	/*
        Construtor com parâmetros.
    */
	public Venda(Float descontoVenda,Long id,Map<Long,ItemVenda> mItensVenda,
				 Pagamento pagamento,Float valorTotal){

		super(null,id,null);		

		this.descontoVenda = descontoVenda;

		this.mItensVenda = mItensVenda;

		this.pagamento = pagamento;

		this.valorTotal = valorTotal;	
	}

	/*
        Métodos getters e setters.
    */
	public Float getDescontoVenda(){

		return this.descontoVenda;
	}

	public Map<Long,ItemVenda> getMItensVenda(){

		/*
           Retorna-se diretamente o mapa (por agora).
		   Pensem nos limites de tipos ;-).
        */
		return this.mItensVenda;
	}

	public Pagamento getPagamento(){

		return this.pagamento;
	}

	public Float getValorTotal(){

		return this.valorTotal;
	}

	public void setDescontoVenda(Float descontoVenda){
		
		this.descontoVenda = descontoVenda;
	}

	public void setMItensVenda(Map<Long,ItemVenda> mItensVenda){

		this.mItensVenda = mItensVenda;
	}

	public void setPagamento(Pagamento pagamento){

		this.pagamento = pagamento;	
	}

	public void setValorTotal(Float valorTotal){

		this.valorTotal = valorTotal;	
	}
}


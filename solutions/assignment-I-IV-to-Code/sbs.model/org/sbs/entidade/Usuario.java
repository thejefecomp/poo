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

import java.util.List;

import org.sbs.entidade.common.Entidade;
import org.sbs.entidade.common.enums.Permissao;

/*
	O modelo indica que todas as senhas devem ser cadastradas no primeiro
	acesso, ou seja, quando senha == null;
*/

public abstract class Usuario extends Entidade{

	private String login;

	/*
		No caso de n??o se utilizar enumerados, as diferentes permiss??es podem 
		ser representadas por Strings. O atribuido fica:
		
		private List<String> lPermissoes;

		As permiss??es podem ser, por exemplo:

		ADMINISTRACAO,
		RELATORIO,
		VENDA,
		TOTAL.
	*/

	private List<Permissao> lPermissoes;

	/*
		 Pode-se perguntar: Por que n??o utilizar uma refer??ncia da classe String
		 que ?? imut??vel? A resposta ??: por quest??es de seguran??a. O fato da 
		 classe String ser imut??vel implica em um problema s??rio em rela????o 
		 ??s senhas. Ao usar um objeto da classe String, toda vez que uma senha ??
		 alterada, cria-se um novo objeto com a nova senha, e o espa??o de 
		 mem??ria da senha anterior continua "acess??vel", a implicar uma 
		 possibilidade de acesso das senhas que j?? foram alteradas. Ao utilizar
		 um array de char, o espa??o de mem??ria pode ser limpo e substitu??do, 
		 algo que n??o se consegue realizar com um objeto da classe String.
	*/
	private char[] senha;

	/*
        Construtor com par??metros.
    */
	public Usuario(String descricao,Long id,String login,
				   List<Permissao> lPermissoes,String nome, char[] senha){

		super(descricao,id,nome);

		this.login = login;

		this.lPermissoes = lPermissoes;

		this.senha = senha;
	}

	/*
        M??todos getters e setters.
    */

	public String getLogin(){

		return this.login;
	}

	public List<Permissao> getLPermissoes(){

		/*
           Retorna-se diretamente a lista (por agora).
		   Pensem nos limites de tipos ;-).
        */
		return this.lPermissoes;
	}

	public char[] getSenha(){

		return this.senha;
	}

	public void setLPermissoes(List<Permissao> lPermissoes){

		this.lPermissoes = lPermissoes;
	}

	public void setSenha(char[] senha){
		
		if(this.senha != null){
		
			for(char charactere : this.senha){
				charactere = 0;
			}
		}

		this.senha = senha;
	}
}


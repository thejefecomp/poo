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

import java.util.Arrays;
import java.util.List;

import org.sbs.entidade.common.enums.Permissao;

public class Administrador extends Usuario{
	
	private List<Long> lTelefones;

	private String sobrenome;

	/*
        Construtor com parâmetros.
    */
	public Administrador(String descricao,Long id,String login,
						 List<Long> lTelefones,String nome,String sobrenome){
  
		super(descricao,id,login,
			  Arrays.asList(Permissao.ADMINISTRACAO),nome,null);

		this.lTelefones = lTelefones;

		this.sobrenome = sobrenome;
	}

	/*
        Métodos getters e setters.
    */
	public List<Long> getLTelefones(){

		/*
           Retorna-se diretamente a lista (por agora).
		   Pensem nos limites de tipos ;-).
        */
		return this.lTelefones;
	}

	public String getSobrenome(){

		return this.sobrenome;
	}

	public void setLTelefones(List<Long> lTelefones){
	
		this.lTelefones = lTelefones;
	}

	public void setSobrenome(String sobrenome){

		this.sobrenome = sobrenome;
	}
}


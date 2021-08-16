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


public class PessoaFisicaVO{

	private Long cpf;

	private String email;	

	private String nome;

	private Long rg;

	private String sobrenome;

	public PessoaFisicaVO(){

		this(null,null,null,null,null);
	}
	
	public PessoaFisicaVO(Long cpf, String email, String nome, Long rg,
						  String sobrenome){

		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.rg = rg;
		this.sobrenome = sobrenome;
	}


	public Long getCpf(){

		return this.cpf;
	}

	public String getEmail(){

		return this.email;
	}

	public String getNome(){

		return this.nome;
	}

	public Long getRg(){

		return this.rg;
	}

	public String getSobrenome(){

		return this.sobrenome;
	}

	public void setCpf(Long cpf){

		this.cpf = cpf;
	}

	public void setEmail(String email){

		this.email = email;
	}

	public void setNome(String nome){

		this.nome = nome;
	}

	public void setRg(Long rg){

		this.rg = rg;
	}

	public void setSobrenome(String sobrenome){

		this.sobrenome = sobrenome;
	}
}

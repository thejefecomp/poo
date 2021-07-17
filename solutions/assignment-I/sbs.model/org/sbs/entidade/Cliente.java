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

public abstract class Cliente extends Entidade{

    private Cartao cartaoFidelidade;

    private String email;

    private List<Endereco> lEnderecos;    
    
    private List<Long> lTelefones;

    /*
        Construtor default sem parâmetros.
    */
    public Cliente(){
    
        this(null,null,null,null,null,null);

    }

    /*
        Construtor com parâmetros.
    */
    public Cliente(Cartao cartaoFidelidade,String descricao,
				   String email,List<Endereco> lEnderecos, 
				   List<Long> lTelefones,String nome){
      
        super(descricao,null,nome);

        this.cartaoFidelidade = cartaoFidelidade;

        this.email = email;

        this.lEnderecos = lEnderecos;

        this.lTelefones = lTelefones;
    }

    /*
        Métodos getters e setters.
    */
    
    public Cartao getCartaoFidelidade(){
        
        return this.cartaoFidelidade;
    }

    public String getEmail(){
        
        return this.email;
    }

    public List<Endereco> getLEnderecos(){
		
		/*
           Retorna-se diretamente a lista (por agora).
		   Pensem nos limites de tipos ;-).
        */       
        return this.lEnderecos;
    }

    public List<Long> getLTelefones(){
        
		/*
           Retorna-se diretamente a lista (por agora).
		   Pensem nos limites de tipos ;-).
        */
        return this.lTelefones;
    }

    public void setCartaoFidelidade(Cartao cartaoFidelidade){
    
        this.cartaoFidelidade = cartaoFidelidade;
    }

    public void setEmail(String email){
    
        this.email = email;
    }

    public void setLEnderecos(List<Endereco> lEnderecos){
    
        this.lEnderecos = lEnderecos;
    }

    public void setLTelefones(List<Long> lTelefones){
    
        this.lTelefones = lTelefones;
    }
    
    /*
        Precisa-se pensar em uma forma mais interessante de 
        atualizar os endereços e os telefones. PS: Pensem nisso :-D.
    */ 
}


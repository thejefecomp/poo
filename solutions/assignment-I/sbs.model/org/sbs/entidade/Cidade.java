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

public class Cidade extends Entidade{

    private Estado estado;    
    
    private Pais pais;

     /*
        Construtor default sem parâmetros.
    */    
    public Cidade(){
    
        this(null,null,null,null,null);       
    }

    /*
        Construtores com parâmetros.
    */
    public Cidade(String nome,Pais pais){

        this(null,null,nome,null,pais);

    }

    public Cidade(Long id,String nome,Pais pais){

        this(null,id,nome,null,pais);
    }

    public Cidade(String descricao,Long id,String nome,Estado estado,Pais pais){
       
        super(descricao,id,nome);

        this.estado = estado;

        if (this.estado != null && this.estado.getPais() != null){

            this.pais = pais;
        }
        else{
            
            this.pais = pais;
        }   
    }

    /*
        Métodos getters e setters.
    */

    public Estado getEstado(){

        return this.estado;
    }

    public Pais getPais(){

        return this.pais;
    }

    public void setEstado(Estado estado){
    
        this.estado = estado;
    }

    public void setPais(Pais pais){
    
        this.pais = pais;
    }
}


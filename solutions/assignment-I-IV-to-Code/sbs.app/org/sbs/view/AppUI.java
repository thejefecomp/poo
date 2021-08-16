package org.sbs.view;

/******************************************************************************
*    Copyright (c)  2018-2021, Jeferson Souza (thejefecomp) - 
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
import java.util.Map;
import java.util.Scanner;

import org.sbs.controller.IController;
import org.sbs.controller.ControllerOperationEnum;
import org.sbs.controller.impl.ControllerImpl;

import org.sbs.view.vo.PessoaFisicaVO;
import org.sbs.view.vo.SapatoVO;
import org.sbs.view.vo.enums.OrigemTamanhoEnum;


public class AppUI{

    private IController controller;

    private Scanner scanner;
    
    private boolean isLoged = false;

    public AppUI(){

	this.controller = new ControllerImpl();

	this.scanner = new Scanner(System.in);
	
    }
    
    public void addCliente(){
    
        this.printMenu(false, "Pessoa Fisica");	
					
	    switch(scanner.nextInt()) {
					
		    case 1: 
				    this.addPessoaFisica();
				    break;
				
		    default:
	
	    }
    }
    
    public void addPessoaFisica(){

		PessoaFisicaVO cliente = new PessoaFisicaVO();

		System.out.println("Digite o cpf do cliente: ");
		cliente.setCpf(this.scanner.nextLong());

		System.out.println("Digite o rg do cliente: ");
		cliente.setRg(this.scanner.nextLong());
	
		System.out.println("Digite o primeiro nome do cliente: ");
		cliente.setNome(this.scanner.next());
	
		System.out.println("Digite o ultimo nome do cliente: ");
		cliente.setSobrenome(this.scanner.next());
		
		if((Boolean) this.controller.execute(ControllerOperationEnum.ADD_PESSOA_FISICA, cliente)){
			
			System.out.println("Cliente Cadastrado com Sucesso!");
		}
		else {
			
			System.out.println("Erro no Cadastro do Cliente!");
		}
    }
    
    public void addVenda(){
    
        
        System.out.println("ESTOU A ESPERA DE SER IMPLEMENTADA!!!");
    
    }
    
    public String completeNumberMask(String number, int expectedLength) {
    	
		StringBuilder sbNumber = new StringBuilder();
    	
    	if(number.length() < expectedLength) {
    		
    		int total = expectedLength - number.length();
    		for(int i = 0; i < total; i++) {
    			sbNumber.append("0");
    		}
    	}
    	
    	sbNumber.append(number);
    	
    	return sbNumber.toString();
    }
    
    @SuppressWarnings("unchecked")
    public void findAllClientes(){
    
        List<PessoaFisicaVO> listaClientes = (List<PessoaFisicaVO>)this.controller.execute(ControllerOperationEnum.FIND_ALL_PESSOA_FISICA);
        
        if (listaClientes == null){
        
            System.out.println("\nNenhum cliente cadastrado!\n");
        }
        else{
            listaClientes.stream().forEach(cliente -> this.printPessoaFisica(cliente));
        }
    }
    
    @SuppressWarnings("unchecked")
    public void findAllSapatos(){
    
        List<SapatoVO> listaSapatos = (List<SapatoVO>)this.controller.execute(ControllerOperationEnum.FIND_ALL_SAPATO);
        
        if (listaSapatos == null){
        
            System.out.println("\nNenhum sapato cadastrado!\n");
        }
        else{
            listaSapatos.stream().forEach(sapato -> this.printSapato(sapato));
        }
    }
    
    public void findCliente(){
    
        this.printMenu(false, "Pessoa Fisica");
					
	    switch(this.scanner.nextInt()) {
	
		    case 1: 
		            this.printMenu(false, "Por Rg", "Por Cpf");	
		            
		            switch(scanner.nextInt()) {
	
		                case 1: this.findCliente(ControllerOperationEnum.FIND_PESSOA_FISICA);
				                break;
				                
				        case 2: this.findCliente(ControllerOperationEnum.FIND_PESSOA_FISICA_CPF);
				                break;
				        default:
			        }
		    default:
	    }
    }
    
    public void findCliente(ControllerOperationEnum tipoOperacao) {
    	
    	String mensagem = tipoOperacao == ControllerOperationEnum.FIND_PESSOA_FISICA 
    	                  ? "Digite o rg: " : "Digite o cpf: ";
    	
    	System.out.println(mensagem);
    	Long campo = this.scanner.nextLong();
    	
    	
    	PessoaFisicaVO resultado = (PessoaFisicaVO) (tipoOperacao == ControllerOperationEnum.FIND_PESSOA_FISICA
    	                        ? this.controller.execute(ControllerOperationEnum.FIND_PESSOA_FISICA, campo)
    	                        : this.controller.execute(ControllerOperationEnum.FIND_PESSOA_FISICA_CPF, campo));
    	
    	if(resultado == null) {
    		
    		System.out.println("Nenhum Cliente Encontrado!");
    		
    		return;
    	}
    	
    	this.printPessoaFisica(resultado);
    }
    
    public void imprimirNotaFiscal(){
    
        System.out.println("ESTOU A ESPERA DE SER IMPLEMENTADA!!!");
    }
    
    public boolean menuLogin(){
    
       this.printMenu(true, "Login");
       
       switch(this.scanner.nextInt()){
       
       
            case 1: this.login();
                    break;
            
            default: return false;
      }
      
      return true;
    }

    public boolean menu(){

        
        if(!isLoged){
        
            return this.menuLogin();
        }
        else{
    	
        	this.printMenu(true, "Cadastrar Cliente", "Encontrar Cliente", "Listar Todos os Clientes", 
        	                     "Listar Sapatos Cadastrados", "Registrar Venda", "Imprimir Nota Fiscal");
        
		    switch(this.scanner.nextInt()){
		
			    case 1: this.addCliente();
					    break;
					
			    case 2: this.findCliente();
					    break;
					    
		        case 3: this.findAllClientes();
		                break;
		                
		        case 4: this.findAllSapatos();
		                break;
		        
		        case 5: this.addVenda();
		                break;
		                
		        case 6: this.imprimirNotaFiscal();
		                break;
		                
			    case 7: 
					    if(this.isLoged){
					    
					        this.isLoged = false;
					    }
					    else{
					    
                            this.scanner.close();
                            
                            return false;
					    }
					
			    default:
		    }
	    }
	    
	    return true;
    }
    
    public void login(){
    
        /*
            TODO
        */
    
        this.isLoged = true;
    }
    
    public void printMenu(boolean root, String ...options) {
    	
    	System.out.println("*********** SentaBota Store Menu *************");
    	System.out.println("Digite a opcao desejada:");
    	
    	for(int i = 0; i < options.length; i++) {
    		
    		System.out.println((i+1) + " - "+ options[i]);
    	}
    	
    	if(root) {
    	
    	    if(this.isLoged){
    	    
    	        System.out.println((options.length +1) + " - Logout");
    		}
    		else{
    		    
    		    System.out.println((options.length +1) + " - Sair");
    		}
    	}
    	else {
    		
    		System.out.println((options.length +1) + " - Voltar");
    	}
    	
    	
    	System.out.println("*********** SentaBota Store Menu *************");
    	
    }
    
    public void printPessoaFisica(PessoaFisicaVO cliente) {
    	
    	System.out.println("\n--- Cliente Pessoa Fisica ---\n");
		System.out.println("CPF: "+ this.completeNumberMask(cliente.getCpf().toString(), 11));
		System.out.println("RG: "+ cliente.getRg());
		System.out.println("Nome: "+cliente.getNome());
    	System.out.println("Sobrenome: "+cliente.getSobrenome());
    	System.out.println("\n--- Fim Cliente Pessoa Fisica ---\n");
    }
    
    public void printSapato(SapatoVO sapato) {
    	
    	System.out.println("\n--- Sapato ---\n");
		System.out.println("Descrição: "+ sapato.getDescricao());
		System.out.println("Modelo: "+sapato.getModelo());
    	System.out.println("Marca: "+sapato.getMarca());
    	System.out.println("Número de Série: "+ sapato.getNumeroSerie());
    	this.printTamanhoSapato(sapato.getMTamanho());
    	System.out.println("\n--- Fim Sapato ---\n");
    }
    
    public void printTamanhoSapato(Map<OrigemTamanhoEnum,Integer> mTamanho) {
    	
    	System.out.println("\n--- Tamanhos ---\n");
    	
    	mTamanho.entrySet().forEach(entry -> {
    	
    	    System.out.printf("%s: %s\n",entry.getKey(),entry.getValue());
    	
    	});
    	
    	System.out.println("\n--- Fim Tamanhos ---\n");    	
    }
}


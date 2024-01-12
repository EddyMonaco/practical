# Diagrama de classe: 

https://drive.google.com/file/d/1EFQ-LsZhwpL-Wu7op_O67Vse1UGflx3p/view?usp=sharing

# Requesitos:

	• O produto deve conter Id, Nome, Quantidade, Fornecedor
	• Limites: Nome 120 caracteres, Quantidade 9999  
	• O Fornecedor pode ser pessoa física ou jurídica
		○ Atributos: Id, Nome, Endereço, CPF(pessoa física), CPNJ(pessoa jurídica)
	• O estoque pode ser feito com um map de produtos e um de fornecedores

 
# Opcional:
	• Disponibilizar acesso via Swagger
	• Usar banco de dados ao invés de map
	• Disponibilizar o artefato compilado
	• Disponibilizar UI


# Modelo Estrutural:

Modelo = entidade;
Serviço = regras de negocio; Ver como usar no spring 
Controller = endpoint
Repositorio = conversa com o banco de dados, JPA;


# DADOS PARA TESTE:

 - INSERT INTO tb_products(name, quantity,supplier_id) VALUES('Mouse', 10, 01);
 - INSERT INTO tb_products(name, quantity,supplier_id) VALUES('Screen', 25, 02);
 - INSERT INTO tb_products(name, quantity,supplier_id) VALUES('Speaker', 5, 03);
 - INSERT INTO tb_products(name, quantity,supplier_id) VALUES('Charger', 5, 04);

 - INSERT INTO tb_supplier(cpf, type_entity, adress, name ) VALUES(99999999999, 'SIMPLE_TYPE', 'Rua Principal, 123', 'RICK');
 - INSERT INTO tb_supplier(cpf, type_entity, adress, name ) VALUES(99999999998, 'SIMPLE_TYPE', 'Rua Principal, 124', 'JIRAYA');
 - IINSERT INTO tb_supplier(cnpj, type_entity, adress, name ) VALUES(99999999997, 'JURIDIC_TYPE', 'Rua Principal, 125', 'LUFFY');
 - INSERT INTO tb_supplier(cnpj, type_entity, adress, name ) VALUES(99999999996, 'JURIDIC_TYPE', 'Rua Principal, 126', 'ITADORI');

# Dependencias

 - H2
 - Lombok
 - JPA
 - Spring Web

INSERT INTO entity_type (is_active, name) VALUES
                                              ('1', 'Desconhecido'),
                                              ('1', 'Cliente'),
                                              ('1', 'Caixa'),
                                              ('1', 'Cozinheiro'),
                                              ('1', 'Gerente');

INSERT INTO order_status (name) VALUES
                                    ('Aguardar Pagamento'),
                                    ('Pago'),
                                    ('Finalizado'),
                                    ('Cancelado');

/*INSERT INTO entities (name, is_active, is_deleted, id_entity_type) VALUES
    ('Utilizador não autenticado', 1, 0, 1);*/
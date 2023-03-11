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

INSERT INTO categories (id, name, description, is_active) VALUES
                                    (1, 'Sandes', 'Sandes', true),
                                    (2, 'Pratos', 'Pratos', true),
                                    (3, 'Pizzas', 'Pizzas', true),
                                    (4, 'Bebidas', 'Bebidas', true);

INSERT INTO public.tax (id, is_deleted, name, tax)
VALUES (1, false, '1', 1);

INSERT INTO public.products (id, is_active, is_deleted, name, price, stock, category_id, tax_id)
VALUES (1, true, false, '1', 1, 1, 1, 1);

/*INSERT INTO entities (name, is_active, is_deleted, id_entity_type) VALUES
    ('Utilizador não autenticado', 1, 0, 1);*/
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

    INSERT INTO categories (name, description, is_active, is_deleted) VALUES
                                        ('Menus', 'Menus', true, false),
                                        ('Sandes', 'Sandes', true, false),
                                        ('Pratos', 'Pratos', true, false),
                                        ('Pizzas', 'Pizzas', true, false),
                                        ('Bebidas', 'Bebidas', true, false);

    INSERT INTO public.tax (id, is_deleted, name, tax)
    VALUES (1, false, '1', 1);

    INSERT INTO public.products (id, is_active, is_deleted, name, price, stock, category_id, tax_id)
    VALUES (1, true, false, 'Kebab', 6.5, 1, 1, 1),
           (2, true, false, 'Kebab Prato', 8.5, 1, 2, 1),
           (3, true, false, 'Pizza Kebab', 10, 1, 3, 1),
           (4, true, false, 'Coca-Cola', 2, 1, 4, 1);

    INSERT INTO public.packs (id, is_active, is_deleted, name, price, stock, id_category_id, id_tax_id)
    VALUES (1, true, false, 'Kebab', 6.5, 1, 1, 1),
           (2, true, false, 'Kebab Prato', 8.5, 1, 2, 1),
           (3, true, false, 'Pizza Kebab', 10, 1, 3, 1),
           (4, true, false, 'Coca-Cola', 2, 1, 4, 1);

    INSERT INTO public.entities (id, address, city, email, fical_id, is_active, is_deleted, name, phone, zip_code, id_entity_type_id)
    VALUES (1, 'rua de santiago', 'Aldreu', 'rodrigo@gmail', 1, true, false, 'Rodrigo', 966682190, 4905-021, 1),
           (2, 'rua do alcazar', 'Barcelos', 'sergio@gmail', 2, true, false, 'Sergio', 931234567, 4905-020, 3),
           (3, 'rua da viana', 'Viana', 'andre@gmail', 3, true, false, 'Andre', 969876543, 4905-013, 4),
           (4, 'rua de deucriste', 'Deucriste', 'pedro@gmail', 4, true, false, 'Pedro', 965656567, 4905-201, 2);


/*INSERT INTO entities (name, is_active, is_deleted, id_entity_type) VALUES
    ('Utilizador não autenticado', 1, 0, 1);*/
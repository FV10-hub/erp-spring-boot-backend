/** insercion de clientes de prueba **/
INSERT INTO public.clientes(create_at, documento, nombre_completo, telefono)
VALUES  (now(), '1234', 'prueba 1', '1234'),
    	(now(), '12345', 'prueba 2', '12345'),
	    (now(), '123456', 'prueba 3', '123456');

/** insercion de productos de prueba **/
INSERT INTO public.productos(codigo_barra, create_at, descripcion, existencia, precio)
VALUES  ('1111', now(), 'pruducto 1', 1, 5000),
        ('2222', now(), 'pruducto 2', 1, 2500),
        ('3333', now(), 'pruducto 3', 1, 3000);
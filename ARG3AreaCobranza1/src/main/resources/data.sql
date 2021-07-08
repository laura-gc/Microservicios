INSERT INTO empleados (id_empleado, correo, direccion, doc_identidad, fecha_registro, nombres, telefono) VALUES(1,'Caro@gmail.com','Av.sol','12349999','2021-02-02','Carolina','79966547')
INSERT INTO clientes (id_cliente, correo, direccion, doc_identidad, fecha_registro, nombres, telefono)VALUES(1,'Laura@gmail.com','Av.sol','963254','2021-05-02','Laura','6365475')
INSERT INTO docventa (id_doc_venta, fecha, id_cliente, id_empleado) VALUES(1,'2020-05-02',1,1)
INSERT INTO deuda (id_deuda, estado, fecha_pago, monto, id_doc_venta)VALUES(1,'por pagar','2021-08-02',500,1)

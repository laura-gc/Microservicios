INSERT INTO Almacen(idAlmacen,nombre, capacidad) VALUES (1,'Almacen1', '50');
INSERT INTO Almacen(idAlmacen,nombre, capacidad) VALUES (2,'Almacen2', '100');
INSERT INTO Almacen(idAlmacen,nombre, capacidad) VALUES (3,'Almacen3', '200');


INSERT INTO Kardex(idKardex,idAlmacen, TipoMov,idDocumento) VALUES (1,1, 'Salida',1020);
INSERT INTO Kardex(idKardex,idAlmacen, TipoMov,idDocumento) VALUES (2,2, 'Entrada',1021);
INSERT INTO Kardex(idKardex,idAlmacen, TipoMov,idDocumento) VALUES (3,3, 'Salida',1022);


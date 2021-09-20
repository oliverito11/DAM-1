ALTER TABLE FACTURAS
	ADD (COD_Oficina INT(4)),
	ADD CHECK (COD_Oficina > 1 AND COD_Oficina < 1000),
	ADD CONSTRAINT FK_FACTURA_COMPRADORES FOREIGN KEY(CIF_Cliente)
		REFERENCES COMPRADORES(CIF_Comprador);
		
ALTER TABLE COMPRADORES
	CHANGE C_Postal Codigo_Postal VARCHAR(5);
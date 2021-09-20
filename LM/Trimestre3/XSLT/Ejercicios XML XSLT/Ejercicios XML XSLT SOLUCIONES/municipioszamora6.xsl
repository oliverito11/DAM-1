<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">


<!-- EJERCICIO 6 Municipios de Zamora. Población del año 2020. Si población > 5000 verde. Si población > 1000 amarillo. En otro caso rojo -->
<html> 
<body>
  <h2>Municipios de Zamora. Población del año 2020. Si población > 5000 verde. Si población > 1000 amarillo. En otro caso rojo</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">Municipio</th>
      <th style="text-align:left">Año 2020</th>
	
    </tr>
    <xsl:for-each select="tabla/municipio">
	
		<!-- Atención a los atributos de sort.
		select indica la etiqueta sobre la que aplicar la ordenación
		
		order:  ascending (orden ascendente)  desccending (orden descendente)
		
		type: tipo de dato sobre el que aplicar la ordenación >>> text (el dato es texto)     number (el dato es un número)
		
		En nuestro caso si no ponemos tipo, lo ordena como si fuera una cadena de caracteres -->
	
		<tr>
		  <td><xsl:value-of select="nombre"/></td>
		  
		  <xsl:choose>
		  <xsl:when test="a2020 &gt; 5000">
		  
		  <td bgcolor="green"><xsl:value-of select="a2020"/></td>
		  </xsl:when>
		  
		  <xsl:when test="a2020 &gt;1000">
		  <td bgcolor="yellow"><xsl:value-of select="a2020"/></td>
		  </xsl:when>
		  
		  <xsl:otherwise>
		  <td bgcolor="red"><xsl:value-of select="a2020"/></td>
		  </xsl:otherwise>
		  </xsl:choose>
		  
		
		</tr>
	
	</xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
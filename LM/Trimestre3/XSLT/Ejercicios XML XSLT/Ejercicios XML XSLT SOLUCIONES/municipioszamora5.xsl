<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">


<!-- EJERCICIO 5 Muncipios de Zamora con unapoblación mayor de 5000 habitantes -->
<html> 
<body>
  <h2>Población municipios Zamora. Población mayor de 5000 habitantes el año 2020</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">Municipio</th>
      <th style="text-align:left">Año 2020</th>
	  <th style="text-align:left">Año 2019</th>
	  <th style="text-align:left">Año 2018</th>
	  <th style="text-align:left">Año 2017</th>
	  <th style="text-align:left">Año 2016</th>
	  <th style="text-align:left">Año 2015</th>
	  <th style="text-align:left">Año 2014</th>
	  <th style="text-align:left">Año 2013</th>
	  <th style="text-align:left">Año 2012</th>
	  <th style="text-align:left">Año 2011</th>
	  <th style="text-align:left">Año 2010</th>
	  <th style="text-align:left">Año 2009</th>
	  <th style="text-align:left">Año 2008</th>
	  <th style="text-align:left">Año 2007</th>
	  <th style="text-align:left">Año 2006</th>
	  <th style="text-align:left">Año 2005</th>
	  <th style="text-align:left">Año 2004</th>
	  <th style="text-align:left">Año 2003</th>
	  <th style="text-align:left">Año 2002</th>
	  <th style="text-align:left">Año 2001</th>
	  <th style="text-align:left">Año 2000</th>
    </tr>
    <xsl:for-each select="tabla/municipio">
	
		<xsl:if test="a2020 &gt; 5000">
			<tr>
			  <td><xsl:value-of select="nombre"/></td>
			  <td><xsl:value-of select="a2020"/></td>
			  <td><xsl:value-of select="a2019"/></td>
			  <td><xsl:value-of select="a2018"/></td>
			  <td><xsl:value-of select="a2017"/></td>
			  <td><xsl:value-of select="a2016"/></td>
			  <td><xsl:value-of select="a2015"/></td>
			  <td><xsl:value-of select="a2014"/></td>
			  <td><xsl:value-of select="a2013"/></td>
			  <td><xsl:value-of select="a2012"/></td>
			  <td><xsl:value-of select="a2011"/></td>
			  <td><xsl:value-of select="a2010"/></td>
			  <td><xsl:value-of select="a2009"/></td>
			  <td><xsl:value-of select="a2008"/></td>
			  <td><xsl:value-of select="a2007"/></td>
			  <td><xsl:value-of select="a2006"/></td>
			  <td><xsl:value-of select="a2005"/></td>
			  <td><xsl:value-of select="a2004"/></td>
			  <td><xsl:value-of select="a2003"/></td>
			  <td><xsl:value-of select="a2002"/></td>
			  <td><xsl:value-of select="a2001"/></td>
			  <td><xsl:value-of select="a2000"/></td>
			</tr>
		</xsl:if>
	</xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
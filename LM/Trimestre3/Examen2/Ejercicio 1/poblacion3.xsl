<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                
                <!-- Título -->
                <h1>Ejercicio 1.3</h1>
                
                <!-- Tabla -->
                <table border="1">

                    <!-- Cabecera -->
                    <tr bgcolor="#9acd32">
                        <th>Provincia</th>
                        <th>M 2020</th>
                        <th>M 2019</th>
                        <th>M 2018</th>
                        <th>M 2017</th>
                        <th>M 2016</th>
                        <th>M 2015</th>
                        <th>M 2014</th>
                        <th>M 2013</th>
                        <th>M 2012</th>
                        <th>M 2011</th>
                        <th>M 2010</th>
                    </tr>

                    <xsl:for-each select="poblacion/provincia">
                        <!-- Se mostrarán los valores ordenados de manera descendente tomando a Mujeres2020 como referencia -->
                        <xsl:sort select="Mujeres2020" data-type="number" order="descending"/>
                        
                        <!-- Solo se mostrarán el nombre de la provincia y su población de mujeres a lo largo de los años -->
                        <tr>
                            <td><xsl:value-of select="nombre" /></td>
                            <td><xsl:value-of select="Mujeres2020" /></td>
                            <td><xsl:value-of select="Mujeres2019" /></td>
                            <td><xsl:value-of select="Mujeres2018" /></td>
                            <td><xsl:value-of select="Mujeres2017" /></td>
                            <td><xsl:value-of select="Mujeres2016" /></td>
                            <td><xsl:value-of select="Mujeres2015" /></td>
                            <td><xsl:value-of select="Mujeres2014" /></td>
                            <td><xsl:value-of select="Mujeres2013" /></td>
                            <td><xsl:value-of select="Mujeres2012" /></td>
                            <td><xsl:value-of select="Mujeres2011" /></td>
                            <td><xsl:value-of select="Mujeres2010" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
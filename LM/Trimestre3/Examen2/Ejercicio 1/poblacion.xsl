<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <!-- Título -->
                <h1>Ejercicio 1.1</h1>

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
                        <th>H 2020</th>
                        <th>H 2019</th>
                        <th>H 2018</th>
                        <th>H 2017</th>
                        <th>H 2016</th>
                        <th>H 2015</th>
                        <th>H 2014</th>
                        <th>H 2013</th>
                        <th>H 2012</th>
                        <th>H 2011</th>
                        <th>H 2010</th>
                        <th>T 2020</th>
                        <th>T 2019</th>
                        <th>T 2018</th>
                        <th>T 2017</th>
                        <th>T 2016</th>
                        <th>T 2015</th>
                        <th>T 2014</th>
                        <th>T 2013</th>
                        <th>T 2012</th>
                        <th>T 2011</th>
                        <th>T 2010</th>
                    </tr>

                    <!-- Se mostraran todos los valores de los distintos años -->
                    <xsl:for-each select="poblacion/provincia">
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
                            <td><xsl:value-of select="Hombres2020" /></td>
                            <td><xsl:value-of select="Hombres2019" /></td>
                            <td><xsl:value-of select="Hombres2018" /></td>
                            <td><xsl:value-of select="Hombres2017" /></td>
                            <td><xsl:value-of select="Hombres2016" /></td>
                            <td><xsl:value-of select="Hombres2015" /></td>
                            <td><xsl:value-of select="Hombres2014" /></td>
                            <td><xsl:value-of select="Hombres2013" /></td>
                            <td><xsl:value-of select="Hombres2012" /></td>
                            <td><xsl:value-of select="Hombres2011" /></td>
                            <td><xsl:value-of select="Hombres2010" /></td>
                            <td><xsl:value-of select="Total2020" /></td>
                            <td><xsl:value-of select="Total2019" /></td>
                            <td><xsl:value-of select="Total2018" /></td>
                            <td><xsl:value-of select="Total2017" /></td>
                            <td><xsl:value-of select="Total2016" /></td>
                            <td><xsl:value-of select="Total2015" /></td>
                            <td><xsl:value-of select="Total2014" /></td>
                            <td><xsl:value-of select="Total2013" /></td>
                            <td><xsl:value-of select="Total2012" /></td>
                            <td><xsl:value-of select="Total2011" /></td>
                            <td><xsl:value-of select="Total2010" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
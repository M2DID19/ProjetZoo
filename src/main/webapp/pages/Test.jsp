<html>
<%--<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>--%>
<f:view>
    <head>
        <title>Page d'accueil de l'application</title>
    </head>
    <body>
    <h:form>
        <h3>Bienvenue <h:outputText value="#{TmpJsf.nom}"/>,</h3>
    </h:form>
    </body>
</f:view>
</html>
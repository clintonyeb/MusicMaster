<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>
<div class="container">
    <g:form action="index" name="search" class="form-inline centered" style="padding-top:20px;" >
        <div class="form-group">
            <label for="searchBox">Keyword:</label>
                <g:textField id="searchBox" name="searchTerm" class="form-control" placeholder="Artist Name"/>
        </div>
        <button type="submit" class="btn btn-primary">Search iTunes</button>
    </g:form>
    <g:if test="${searchResults}">
        <div class="page-header">
            <h3 class="centered">Search Results For ${searchTerm}</h3>
        </div>

            <g:each in="${searchResults}" var="album">
                <div class="col-md-3 col-xs-6">
                    <g:render template="albumTemplate" model="[album: album]" />
                </div>
            </g:each>
    </g:if>
</div>
</body>
</html>
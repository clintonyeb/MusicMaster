<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="container">
    <div class="page-header centered">
        <h1>Homepage of the MusicMaster Application</h1>
    </div>
    <g:if test="${albums}">
        <h3 class="centered">Recently released albums!</h3>
            <g:each in="${albums}" var="album">
                    <div class="col-md-3 col-xs-6">
                        <g:render template="/album/albumTemplate" model="[album: album]" />
                    </div>
            </g:each>
    </g:if>
</div>
</body>
</html>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
	<meta name="keywords" content="Biblioteca, Sistema, HTML5">
	<meta name="description" content="BiBSystem é um sistema implementado em JAVA destinado ao controle de acervo e empréstimos de uma biblioteca. Possui como prioridade uma boa aparência e facilitar a navegação do usuário.">
	<title>BiBSystem</title>
	<link rel="icon" href="favicon.ico" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<header> <img id="logo" src="images/BiBSystemHeader.png" alt="BiBSystemHeader" onMouseOver="bannerGifOn()" onMouseOut="bannerGifOff()">
		<div class="buttonColors">
			<button id="colorBlack"></button>
			<button id="colorGray"></button>
			<button id="colorBlue"></button>
		</div>
	</header>
<nav>
	<a href="index.php">Início</a>
	<a href="noticias/index.html">Notícias</a>
	<a href="forum">Fórum</a>
	<a href="contac/index.htmlt">Contato</a>
	<a href="sobre/index.html">Sobre</a>
	<a href="login/index.php" class="sign">Entrar</a>
	<a href="signup/index.php" class="sign">Cadastrar-se</a>
  </nav>
	<div class="container">
		<aside>
			<h2>Notícias</h2>
			<ul>
				<li><a href="noticias/#v1-2">Versão 1.2</a></li>
				<li><a href="noticias/#v1-1">Versão 1.1</a></li>
				<li><a href="noticias/#v1-0">Versão 1.0</a></li>
			</ul>
			<p><a href="noticias">Mais versões.</a></p>

			<iframe width="400" height="250" src="https://www.youtube.com/embed/2ZC3rM2Y8jQ" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
		</aside>
		<main>
			<h1>BIBSystem</h1>
			<section>
				<h2>Sobre o produto</h2>
				<p>O Software foi desenvolvido dentro da disciplina de I.H.C. (Interface Humano-Computador) para atender as necessidades de um estudo de caso de uma biblioteca, transformando gerenciamento manual em digital que são controlados pelos funcionários, melhorando conseqüentemente a qualidade do atendimento do serviço. <a href="sobre">[Veja mais]</a></p>
			</section>
			<section>
				<h2>Imagens do produto</h2>
				<a href="images/screenshot_01.jpg"><img src="images/screenshot_01.jpg" width="300" height="200" alt="Screenshot 01"></a>
				<a href="images/screenshot_02.jpg"><img src="images/screenshot_02.jpg" width="300" height="200" alt="Screenshot 02"></a>
			</section>
		</main>
	</div>
	<footer>
		<p id="footerCopyrights">
			&copy;Copyright 2018 <a target="_blank" href="index.php">BiBSystem</a>. All rights reserved.
		</p>
	</footer>
</body>
</html>

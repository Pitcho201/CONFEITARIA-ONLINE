<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Contato – Confeitaria Online</title>
  <style>
    /* Reset básico */
    * { margin: 0; padding: 0; box-sizing: border-box; }

    /* Tipografia e cores */
    body {
      font-family: Arial, sans-serif;
      background-color: #ffe6f0; /* Rosa suave */
      color: #333;
      line-height: 1.6;
    }
    a { text-decoration: none; color: inherit; }

    /* Container centralizado */
    .container {
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
    }

    /* Cabeçalho / Navegação */
    header {
      background-color: #fff;
      border-bottom: 2px solid #eaeaea;
      padding: 20px 0;
      position: relative;
    }
    header h1 {
      text-align: center;
      font-size: 2rem;
      margin-bottom: 10px;
    }
    .nav-toggle {
      display: none;
      position: absolute;
      top: 30px;
      right: 20px;
      font-size: 1.8rem;
      cursor: pointer;
    }
    nav {
      display: flex;
      justify-content: center;
      gap: 30px;
    }
    nav a {
      padding: 5px 0;
      transition: color 0.3s, border-bottom 0.3s;
    }
    nav a:hover {
      color: #E63946;
      border-bottom: 2px solid #E63946;
    }

    /* Conteúdo principal */
    main {
      margin: 40px 0;
      min-height: 60vh;
    }

    /* Rodapé */
    footer {
      background-color: #1a2732;
      color: #fff;
      padding: 40px 0;
    }
    .footer-row {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      gap: 20px;
    }
    .footer-col {
      flex: 1 1 200px;
    }
    .footer-col h4 {
      margin-bottom: 15px;
      font-size: 1.1rem;
    }
    .footer-col ul {
      list-style: none;
      padding: 0;
    }
    .footer-col ul li {
      margin-bottom: 10px;
    }
    .footer-col img {
      height: 30px;
      width: auto;
      margin-right: 10px;
      vertical-align: middle;
    }
    .footer-col img:last-child {
      margin-right: 0;
    }
    .support img {
      height: 20px;
      margin-right: 8px;
      vertical-align: middle;
    }

    /* Responsivo */
    @media (max-width: 768px) {
      .nav-toggle {
        display: block;
      }
      nav {
        display: none;
        flex-direction: column;
        gap: 0;
      }
      nav.active {
        display: flex;
      }
      nav a {
        margin: 10px 0;
      }
      .footer-row {
        flex-direction: column;
      }
    }
  </style>
</head>
<body>
  <div class="container">

    <!-- HEADER -->
    <header>
      <h1>Fale Conosco</h1>
      <span class="nav-toggle">&#9776;</span>
      <nav>
        <a th:href="@{/}">Início</a>
        <a th:href="@{/produtos}">Produtos</a>
        <a th:href="@{/contatos}">Contato</a>
        <a th:href="@{/login}">Login</a>
      </nav>
    </header>

    <!-- MAIN -->
    <main>
      <div style="max-width:600px; margin: 0 auto;">
        <form method="post" action="/contatos">
          <input type="hidden" name="_csrf" th:value="${_csrf.token}">
          <div class="form-group" style="margin-bottom:15px;">
            <label for="nome">Nome</label><br>
            <input type="text" id="nome" name="nome" required
                   style="width:100%; padding:8px; border:1px solid #ccc; border-radius:4px;">
          </div>
          <div class="form-group" style="margin-bottom:15px;">
            <label for="email">E-mail</label><br>
            <input type="email" id="email" name="email" required
                   style="width:100%; padding:8px; border:1px solid #ccc; border-radius:4px;">
          </div>
          <div class="form-group" style="margin-bottom:20px;">
            <label for="mensagem">Mensagem</label><br>
            <textarea id="mensagem" name="mensagem" rows="4" required
                      style="width:100%; padding:8px; border:1px solid #ccc; border-radius:4px;"></textarea>
          </div>
          <button type="submit"
                  style="width:100%; padding:10px; background:#2a9d8f; color:#fff;
                         border:none; border-radius:4px; cursor:pointer;">
            Enviar
          </button>
        </form>
      </div>
    </main>

  </div>

  <!-- FOOTER -->
  <footer>
    <div class="container">
      <div class="footer-row">

        <!-- Redes Sociais -->
        <div class="footer-col">
          <h4>Redes Sociais</h4>
          <ul style="display:flex; gap:15px; padding:0;">
            <li><a href="#"><img th:src="@{/images/facebook.png}" alt="Facebook"/> Facebook</a></li>
            <li><a href="#"><img th:src="@{/images/instagram.png}" alt="Instagram"/> Instagram</a></li>
            <li><a href="#"><img th:src="@{/images/youtube.png}" alt="YouTube"/> YouTube</a></li>
            <li><a href="#"><img th:src="@{/images/linkedin.png}" alt="LinkedIn"/> LinkedIn</a></li>
          </ul>
        </div>

        <!-- Institucional -->
        <div class="footer-col">
          <h4>Institucional</h4>
          <ul>
            <li><a th:href="@{/sobre}">Sobre nós</a></li>
            <li><a th:href="@{/termos}">Termos de uso</a></li>
            <li><a th:href="@{/privacidade}">Política de privacidade</a></li>
          </ul>
        </div>

        <!-- Dúvidas -->
        <div class="footer-col">
          <h4>Dúvidas</h4>
          <ul>
            <li><a th:href="@{/faq}">Perguntas frequentes</a></li>
            <li><a th:href="@{/suporte}">Suporte</a></li>
          </ul>
        </div>

        <!-- Formas de pagamento -->
        <div class="footer-col">
          <h4>Formas de pagamento</h4>
          <img th:src="@{/images/express1.jpg}" alt="Multicaixa"/>
          <img th:src="@{/images/express2.jpg}" alt="Express"/>
          <img th:src="@{/images/express3.jpg}" alt="Transferência Bancária"/>
        </div>

        <!-- Suporte -->
        <div class="footer-col">
          <h4>Suporte</h4>
          <ul class="support" style="padding:0; list-style:none;">
            <li><img th:src="@{/images/relogio.png}" alt="Horário"/> Seg–Sex, 8h–17h</li>
            <li><img th:src="@{/images/Telefone.png}" alt="Telefone"/> (+244) 945718730</li>
            <li><img th:src="@{/images/Telefone.png}" alt="Celular"/> (+244) 941755668</li>
            <li><img th:src="@{/images/whatsapp.png}" alt="WhatsApp"/> (+244) 945718730</li>
            <li><img th:src="@{/images/email.png}" alt="E-mail"/> pitchojpn@gmail.com</li>
          </ul>
        </div>

      </div>
    </div>
  </footer>

  <!-- Script do menu móvel -->
  <script>
    const navToggle = document.querySelector('.nav-toggle'),
          nav       = document.querySelector('nav');
    navToggle.addEventListener('click', () => nav.classList.toggle('active'));
  </script>
</body>
</html>

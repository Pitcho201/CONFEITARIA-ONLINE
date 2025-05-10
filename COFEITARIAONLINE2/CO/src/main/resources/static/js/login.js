// login.js

// Função que verifica a URL para o parâmetro 'message'
function showErrorMessage() {
    const urlParams = new URLSearchParams(window.location.search);
    const errorMessage = urlParams.get('message');

    if (errorMessage) {
        const errorDiv = document.getElementById('error-message');
        errorDiv.textContent = errorMessage; // Exibe a mensagem de erro
    }
}

// Chama a função para exibir a mensagem de erro quando a página carregar
window.onload = showErrorMessage;

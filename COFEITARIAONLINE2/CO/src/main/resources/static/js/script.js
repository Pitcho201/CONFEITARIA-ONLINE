document.addEventListener("DOMContentLoaded", () => {
    console.log("Sistema Confeitaria Online iniciado!");

    // Função para alertar o usuário ao adicionar um produto ao pedido
    const addButtons = document.querySelectorAll(".add-to-cart");
    addButtons.forEach(button => {
        button.addEventListener("click", () => {
            alert("Produto adicionado ao pedido!");
        });
    });
});

document.getElementById('cadastroUsuario').addEventListener('submit', function(event) {
    event.preventDefault();

    // Captura os dados do formulário
    const nome = document.getElementById('nome-user').value;
    const email = document.getElementById('email-user').value;
    const phoneNumber = document.getElementById('number-user').value;

    // Cria o objeto a ser enviado
    const dados = {
        name: nome,
        email: email,
        phoneNumber: phoneNumber
    };

    // Envia os dados para a API usando fetch (POST)
    fetch('http://localhost:8080/user', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Erro ao cadastrar usuário');
        }
    })
    .then(data => {
        alert('Usuário cadastrado com sucesso!');
        console.log(data);
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Ocorreu um erro ao cadastrar o usuário.');
    });
});


document.getElementById('carregarDados').addEventListener('click', function() {
    // Faz uma requisição GET para buscar os dados
    fetch('http://localhost:8080/user', {  // Substitua pelo endpoint correto da sua API
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        // Limpa a tabela antes de adicionar novos dados
        const tbody = document.getElementById('tabelaUsuarios').getElementsByTagName('tbody')[0];
        tbody.innerHTML = '';  // Limpa as linhas antigas

        // Percorre os dados e adiciona cada um na tabela
        data.forEach(usuario => {
            let novaLinha = tbody.insertRow();
            
            let idCelula = novaLinha.insertCell();
            idCelula.textContent = usuario.id;

            let nomeCelula = novaLinha.insertCell();
            nomeCelula.textContent = usuario.name;  

            let emailCelula = novaLinha.insertCell();
            emailCelula.textContent = usuario.email;  

            let phoneCelula = novaLinha.insertCell();
            phoneCelula.textContent = usuario.phoneNumber;
        });
    })
    .catch(error => {
        console.error('Erro ao carregar usuários:', error);
        alert('Erro ao carregar usuários.');
    });
});

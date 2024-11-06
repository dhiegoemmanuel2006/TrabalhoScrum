document.getElementById('cadastroUsuario').addEventListener('submit', handleSubmit);

//Ações feitas após clicar
function handleSubmit(event) {
    event.preventDefault();
    const dados = captureFormData();
    sendData(dados);
}

//Captura dos dados do formulário para depois eniar
function captureFormData() {
    return {
        name: document.getElementById('nome-user').value,
        email: document.getElementById('email-user').value,
        phoneNumber: document.getElementById('number-user').value
    };
}

//Local onde envia os dados e captura dos possíveis erros
function sendData(dados) {
    fetch('http://localhost:8080/user', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dados)
    })
        .then(handleResponse)
        .then(data => {
            alert('Usuário cadastrado com sucesso!');
            console.log(data);
        })
        .catch(handleError);
}

function handleResponse(response) {
    if (!response.ok) {
        return response.json().then(error => {
            throw new Error(error.message);
        });
    }
    return response.json();
}

function handleError(error) {
    console.error('Erro:', error);
    alert('Ocorreu um erro ao cadastrar o usuário: ' + error);
}


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
        alert(error);
    });
});

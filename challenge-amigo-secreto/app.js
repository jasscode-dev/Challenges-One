let friendsList = [];
let isDrawActive = true;

const friendInput = document.getElementById('amigo');
const friendsDisplay = document.getElementById('listaAmigos');
const resultDisplay = document.getElementById('resultado');

function addFriend() {
    const friendName = friendInput.value.trim();

    if (!isDrawActive) {
        alert("Por favor, recomece o sorteio para adicionar mais amigos.");
        return;
    }

    if (friendName === "") {
        alert("Por favor, insira um nome.");
        return;
    }

    if (!isNaN(friendName)) {
        alert("Por favor, insira um nome válido (sem números).");
        return;
    }

    friendsList.push(friendName);
    friendInput.value = "";
    updateFriendList();
}

function updateFriendList() {
    friendsDisplay.innerHTML = "";

    if (isDrawActive) {
        friendsList.forEach((friend) => {
            friendsDisplay.insertAdjacentHTML('beforeend', `<li>${friend}</li>`);
        });
    }
}

function drawFriend() {
    if (friendsList.length === 0) {
        alert("A lista de amigos está vazia. Adicione ao menos um nome para realizar o sorteio.");
        return;
    }

    const randomIndex = Math.floor(Math.random() * friendsList.length);
    const selectedFriend = friendsList[randomIndex];

    friendsDisplay.innerHTML = "";
    resultDisplay.innerHTML = `<li>O amigo sorteado é: <strong>${selectedFriend}</strong></li>`;
    isDrawActive = false;
}

function resetDraw() {
    friendsList = [];
    isDrawActive = true;
    friendInput.value = "";
    resultDisplay.innerHTML = "";
    updateFriendList();
}

document.getElementById('btnAdicionar').addEventListener('click', addFriend);
document.getElementById('btnSortear').addEventListener('click', drawFriend);
document.getElementById('btnResetar').addEventListener('click', resetDraw);

function showActivity() {
    document.querySelectorAll('.top-menu button').forEach(btn => {
        btn.classList.remove('active');
    });
    document.querySelector('.content').innerHTML = `
        <div class="row">
            <button class="block button" id="gym" onclick="showGym()">GYM</button>
            <button class="block button" id="badminton" onclick="showBadminton()">Badminton</button>
        </div>
        <div class="row">
            <button class="block button" id="football" onclick="showFootball()">Football</button>
            <button class="block button" id="basketball" onclick="showBasketball()">Basketball</button>
        </div>
    `;
    document.querySelector('.top-menu button:nth-child(1)').classList.add('active'); // 添加 active 类
}

function showOrder() {
    // window.location.href = "order.html";
}

function showIndividual() {
    window.location.href = "userInfo.html";
}

function showGym() {
    window.location.href = "./gymPage.html";
}

function showBadminton() {
    window.location.href = "./badmintonPage.html";
}

function showFootball() {
    window.location.href = "./footballPage.html";
}

function showBasketball() {
    window.location.href = "./basketballPage.html";
}

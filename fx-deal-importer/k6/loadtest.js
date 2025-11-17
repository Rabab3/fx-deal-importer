import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    vus: 10,          // Nombre d'utilisateurs simultanés
    duration: '30s',  // Durée du test
};

const BASE_URL = "https://fakestoreapi.com";

export default function () {

    // 1️⃣ --- AUTHENTIFICATION ---
    let loginPayload = JSON.stringify({
        username: "mor_2314",
        password: "83r5^_"
    });

    let loginHeaders = {
        'Content-Type': 'application/json'
    };

    let loginRes = http.post(`${BASE_URL}/auth/login`, loginPayload, { headers: loginHeaders });

    check(loginRes, {
        "login status 200": (r) => r.status === 200,
        "login returns token": (r) => r.json("token") !== "",
    });

    let token = loginRes.json("token");

    // 2️⃣ --- GET PRODUCTS AVEC JWT ---
    let productHeaders = {
        'Authorization': `Bearer ${token}`
    };

    let productsRes = http.get(`${BASE_URL}/products`, { headers: productHeaders });

    check(productsRes, {
        "products status 200": (r) => r.status === 200,
        "products list received": (r) => r.json().length > 0
    });

    sleep(1);
}

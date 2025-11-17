import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    vus: 50,
    duration: '30s',
};

export default function () {
    let payload = JSON.stringify({
        dealId: `D${Math.floor(Math.random()*10000)}`,
        fromCurrency: "USD",
        toCurrency: "EUR",
        timestamp: "2025-11-17T12:00:00",
        amount: 1000
    });

    let params = { headers: { "Content-Type": "application/json" } };

    let res = http.post("http://localhost:8080/api/deals", payload, params);

    check(res, {
        "status is 201": (r) => r.status === 201
    });

    sleep(1);
}

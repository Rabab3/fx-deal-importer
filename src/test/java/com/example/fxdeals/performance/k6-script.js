import http from 'k6/http';
import { sleep, check } from 'k6';

export let options = {
    vus: 20,
    duration: '15s',
};

export default function () {
    const payload = JSON.stringify({
        dealId: `K6${Math.random()}`,
        fromCurrency: "USD",
        toCurrency: "EUR",
        timestamp: "2024-01-01T12:00:00",
        amount: 1000
    });

    const headers = { 'Content-Type': 'application/json' };

    let res = http.post('http://localhost:8080/api/deals', payload, { headers });

    check(res, {
        'status is 201': r => r.status === 201
    });

    sleep(1);
}

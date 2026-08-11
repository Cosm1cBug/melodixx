# Hosting your own Listen Together server

**GitHub Pages cannot host Listen Together.** Pages serves static files only;
Listen Together needs a long-lived **WebSocket relay** (the `metroserver`
project from the Metrolist ecosystem).

## Where it CAN run
- Any VPS with Docker (Hetzner/Oracle free tier/DigitalOcean): run the
  `metroserver` image and expose the WS port.
- Managed containers: Render / Fly.io / Railway / Google Cloud Run — deploy
  the same image; ensure the port accepts WebSocket upgrades.

## Connect Melodix to it
In-app: Listen Together → Settings → Server URL → enable *custom server* and
paste your `wss://your.host/ws` URL. The upstream public relay remains the
default until you change it.

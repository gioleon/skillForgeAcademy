/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      backgroundImage: {
        login: "url('./src/img/hero-login.jpg')",
        register: "url('/src/img/hero-register.jpg')",
      },
    },
  },
  plugins: [require("daisyui")],
};

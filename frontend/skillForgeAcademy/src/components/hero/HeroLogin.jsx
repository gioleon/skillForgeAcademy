import React from "react";

export default function HeroLogin() {
  return (
    <div
      className="hero min-h-screen"
      style={{
        backgroundImage: `url("src/img/hero-home.jpg")`,
      }}
    >
      <div className="hero-overlay bg-opacity-60"></div>
      <div className="hero-content text-center text-neutral-content">
        <div className="max-w-md">
          <h1 className="mb-5 text-6xl font-bold text-center">SkillForge Academy</h1>
          <p className="mb-5">
            El lugar donde podrás estudiar, aprender y reforzar tus
            conocimientos
          </p>
          <button className="btn btn-primary">Conoce más ✋</button>
        </div>
      </div>
    </div>
  );
}

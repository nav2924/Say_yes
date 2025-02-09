const messages = [
    "Are you really sure, my love? 💕",
    "Think about how much I adore you! 😘",
    "You wouldn't break my heart, would you? 🥺",
    "Pretty please, my sunshine? 🌞",
    "You're my whole world, you know that? 🌎",
    "If you say no, my heart might just stop... 💔",
    "But I know you love me too, right? 🥰",
    "Every heartbeat of mine whispers your name... 💓",
    "Imagine a lifetime of cuddles and kisses! 🥺💕",
    "I promise to always be your safe place! 🤗",
    "Together, we can write the most beautiful love story... 📖❤️",
    "I can't imagine a life without you, my angel! 👼",
    "You're the reason my heart smiles every day! 😊",
    "A thousand times yes to loving you forever! 💍❤️",
    "Okay, I’ll stop... but just one last time—say yes, my love! 💞"
];


let messageIndex = 0;

function handleNoClick() {
    const noButton = document.querySelector('.no-button');
    const yesButton = document.querySelector('.yes-button');
    noButton.textContent = messages[messageIndex];
    messageIndex = (messageIndex + 1) % messages.length;
    const currentSize = parseFloat(window.getComputedStyle(yesButton).fontSize);
    yesButton.style.fontSize = `${currentSize * 1.15}px`;
}

function handleYesClick() {
    window.location.href = "yes.html";
}
import readlineSync from 'readline-sync';
import { car, cdr } from 'hexlet-pairs';

export const iterationsCount = 3; // set the number of questions

const playGame = (counter, generateGameData) => {
  if (counter === 0) {
    return true;
  }

  const gameData = generateGameData();
  const question = car(gameData);
  const calculatedAnswer = cdr(gameData);
  console.log(`Question: ${question}`);
  const userAnswer = readlineSync.question('Your answer: ');

  if (userAnswer === calculatedAnswer) {
    console.log('Correct!');
    return playGame(counter - 1, generateGameData);
  }

  console.log(`'${userAnswer}' is wrong answer ;(. Correct answer was '${calculatedAnswer}'.`);
  return false;
};

export const makeGame = (generateGameData, rule) => {
  console.log('\nWelcome to the Brain Games!');

  console.log(rule);

  const userName = readlineSync.question('\nMay I have your name? ');
  console.log(`Hello, ${userName}!\n`);

  const gameResult = playGame(iterationsCount, generateGameData);

  if (gameResult) {
    console.log(`Congratulations, ${userName}!`);
  } else {
    console.log(`Let's try again, ${userName}!\n`);
  }
};

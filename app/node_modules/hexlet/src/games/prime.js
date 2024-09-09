import { cons } from 'hexlet-pairs';
import { makeGame } from '..';
import generateNumber from '../utils';

const rule = 'Answer "yes" if number prime otherwise answer "no".';

const valueRangeMin = 1;
const valueRangeMax = 30;

const isPrime = (num) => {
  if (num <= 1) {
    return false;
  }

  const iter = (divider) => {
    if (divider <= num / 2) {
      if (num % divider === 0) {
        return false;
      }
    } else {
      return true;
    }

    return iter(divider + 1);
  };

  return iter(2);
};

const askPrime = () => {
  const num = generateNumber(valueRangeMin, valueRangeMax);
  const question = `${num}`;
  const answer = isPrime(num) ? 'yes' : 'no';
  const game = cons(question, answer);
  return game;
};

const startPrimeGame = () => makeGame(askPrime, rule);

export default startPrimeGame;

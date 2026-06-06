module.exports = {
    testEnvironment: 'node',
    silent: false,
    transform: {
      '^.+\\.(t|j)sx?$': ['@swc/jest'],
    },
  };
import { Flex } from "@chakra-ui/react";
import { ErrorMessage } from "../components/ErrorMessage";

export const NotFoundPage = () => {
  return (
    <>
      <Flex
        style={{ perspective: "1000px" }}
        minH="100vh"
        w="100%"
        align="center"
        justify="center"
        bg="black"
      >
        <Flex
          style={{ perspective: "1000px" }}          
          h="500px"          
          w="95%"
          maxW="800px"
          align="center"
          justify="center"
          direction="column"
          backgroundImage="linear-gradient(to left top, #2a32e7, #0052f2, #006bf9, #0081fc, #2496fc, #4f98fc, #699afc, #7e9cfc, #9f89f5, #c171e4, #df52c8, #f423a2)"
          borderRadius="50px"
        >
          <ErrorMessage />
        </Flex>
      </Flex>
    </>
  );
};
